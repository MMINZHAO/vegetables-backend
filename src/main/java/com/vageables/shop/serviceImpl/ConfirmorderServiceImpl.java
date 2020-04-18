package com.vageables.shop.serviceImpl;

import com.vageables.shop.entity.Confirmorder;
import com.vageables.shop.entity.Userinfo;
import com.vageables.shop.repository.ConfirmorderRepository;
import com.vageables.shop.service.ConfirmorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 13:31
 * @description : --ConfirmorderServiceImpl类描述--
 */

@Service
public class ConfirmorderServiceImpl implements ConfirmorderService {
    @Autowired
    private ConfirmorderRepository confirmorderRepository;

    @Override
    public Object AddConfirmorder(Confirmorder confirmorder) {
        return confirmorderRepository.save(confirmorder);
    }

    @Override
    public List<Confirmorder> ViewConfirmorders() {
        return confirmorderRepository.findAll();
    }

    @Override
    public void DeleteConfirmorder(Confirmorder confirmorder) {
        confirmorderRepository.deleteById(confirmorder.getId());
    }

    @Override
    public List<Confirmorder> ViewConfirmorders(Userinfo userinfo) {
        return confirmorderRepository.findAllByUserid(userinfo.getId());
    }

    @Override
    public List<Confirmorder> getMaxID() {
        return confirmorderRepository.getMaxID();
    }
}
