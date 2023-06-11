package com.boutique.jabaklah.service;

import com.boutique.jabaklah.model.Cart;

public interface CartService {

    boolean saveCart(Cart cart);

    boolean updateCart(Cart cart);

    Cart findCart();

}
