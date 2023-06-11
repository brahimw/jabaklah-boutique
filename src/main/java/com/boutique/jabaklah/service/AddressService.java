package com.boutique.jabaklah.service;

import com.boutique.jabaklah.model.Address;

public interface AddressService {

    boolean saveAddress(Address address);

    Address findAddressByBilling(boolean billing);

}
