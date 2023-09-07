package com.opticarlos.infrastructure.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

public class InsertDataToPostgreSQL {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/opticarlosdb";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root123";

    private static final String[] CATEGORIES = {
            "EYEGLASSES",
            "SUNGLASSES",
            "CONTACT_LENS",
            "ACCESSORIES"
    };

    private static final String[] EYEGLASSES = {
            "Classic Black Eyeglasses",
            "Vintage Round Frames",
            "Modern Titanium Eyeglasses",
            "Fashionable Cat-Eye Glasses"
    };

    private static final String[] SUNGLASSES = {
            "Polarized Aviator Sunglasses",
            "Designer Oversized Shades",
            "Sporty Wrap-around Sunglasses",
            "Chic Wayfarer Sunglasses"
    };

    private static final String[] CONTACT_LENSES = {
            "Daily Disposable Contact Lenses",
            "Monthly Colored Contact Lenses",
            "Astigmatism Correcting Lenses",
            "Multifocal Contact Lenses"
    };

    private static final String[] ACCESSORIES = {
            "Eyeglass Cases",
            "Lens Cleaning Kits",
            "Stylish Eyeglass Chains",
            "UV Protection Sunglass Clips"
    };

    private static final String[] GENDERS = {
            "MAN",
            "WOMAN"
    };

    private static final String[] BRANDS = {
            "Ray-Ban",
            "Oakley",
            "Prada",
            "Gucci",
            "Dior",
            "Versace",
            "Tom Ford",
            "Burberry",
            "Emporio Armani",
            "Calvin Klein"
    };

    private static final String[] DESCRIPTIONS = {
            "Elegant and modern sunglasses.",
            "Daily contact lenses for comfortable vision.",
            "High-quality reading glasses.",
            "Eye care accessories.",
            "Luxury sunglasses with UV protection.",
            "Monthly contact lenses for crisp vision.",
            "Sporty sunglasses for outdoor activities.",
            "Fashion accessories for your glasses.",
            "Designer eyeglasses with metal frames.",
            "Toric contact lenses to correct astigmatism."
    };

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            clearTable(connection);

            String insertSql = "INSERT INTO products " +
                    "(product_id, active, brand, category, date_created, date_updated, description, gender, image, name, price, stock) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);

            Random random = new Random();

            for (int i = 1; i <= 25; i++) {
                preparedStatement.setLong(1, i);
                preparedStatement.setBoolean(2, true);
                preparedStatement.setString(3, getRandomElement(BRANDS, random));
                String category = CATEGORIES[i % CATEGORIES.length];
                preparedStatement.setString(4, category);
                Timestamp now = new Timestamp(System.currentTimeMillis());
                preparedStatement.setTimestamp(5, now);
                preparedStatement.setTimestamp(6, now);

                String productName = getRandomProductName(category, random);
                preparedStatement.setString(10, productName);

                String description = getRandomDescription(category, random);
                preparedStatement.setString(7, description);

                preparedStatement.setString(8, getRandomElement(GENDERS, random));
                preparedStatement.setString(9, "image_" + i + ".jpg");
                preparedStatement.setDouble(11, random.nextDouble(19.99, 99.99));
                preparedStatement.setInt(12, random.nextInt(0, 100));
                preparedStatement.executeUpdate();
            }

            System.out.println("Insert OK");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void clearTable(Connection connection) throws SQLException {
        String truncateSql = "TRUNCATE TABLE products";
        PreparedStatement truncateStatement = connection.prepareStatement(truncateSql);
        truncateStatement.executeUpdate();
    }

    private static String getRandomElement(String[] array, Random random) {
        return array[random.nextInt(array.length)];
    }

    private static String getRandomProductName(String category, Random random) {
        switch (category) {
            case "EYEGLASSES":
                return getRandomElement(EYEGLASSES, random);
            case "SUNGLASSES":
                return getRandomElement(SUNGLASSES, random);
            case "CONTACT_LENS":
                return getRandomElement(CONTACT_LENSES, random);
            case "ACCESSORIES":
                return getRandomElement(ACCESSORIES, random);
            default:
                return "Product " + random.nextInt(100);
        }
    }

    private static String getRandomDescription(String category, Random random) {
        switch (category) {
            case "EYEGLASSES":
            case "SUNGLASSES":
            case "CONTACT_LENS":
            case "ACCESSORIES":
                return getRandomElement(DESCRIPTIONS, random);
            default:
                return "Description for " + getRandomProductName(category, random);
        }
    }

}
