SrIn�gs   	  H X    ( �    " �   
  �   
  �   
  �   
  �     �   
          O n e D r i v e S y n c R o o t                                 O n e D r i v e   -   B u s i n e s s   2 3 . 1 7 4 . 0 8 2 0 . 0 0 0 3      	         9"b�)I��bT�i�                                                                                                                                                                                                                                                    ringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;  Invalid product data:  InnerClasses " %java/lang/invoke/MethodHandles$Lookup $ java/lang/invoke/MethodHandles Lookup !         	 
     C     *+�   � �       
     
                                             
  ! # %                                                                 st<Product> products = productServices.getAllProducts(filterBy);
        List<ProductResponse> productResponses = products.stream()
                .map(ProductResponse::fromProduct)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productResponses);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId) {
        Product product = productServices.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(ProductResponse.fromProduct(product));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduc