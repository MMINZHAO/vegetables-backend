package com.vageables.shop.serviceImpl;

import com.vageables.shop.entity.Address;
import com.vageables.shop.entity.Userinfo;
import com.vageables.shop.repository.AddressRepository;
import com.vageables.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : hello
 * @date : 2020/4/8 12:55
 * @description : --AddressServiceImpl类描述--
 */

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Object AddAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void DeleteAddress(Address address) {
        addressRepository.deleteById(address.getId());
    }

    @Override
    public Object EditAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> ViewAddress(Userinfo userinfo) {
        return addressRepository.findAllByUserid(userinfo.getId());
    }
}
