package com.spr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spr.exception.ShopNotFound;
import com.spr.model.Shop;
import com.spr.repository.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Resource
	private ShopRepository shopRepository;

	@Override
	@Transactional
	public Shop create(Shop shop) {
		Shop createdShop = shop;
		return shopRepository.save(createdShop);
	}
	
	@Override
	@Transactional
	public Shop findById(int id) {
		return shopRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=ShopNotFound.class)
	public Shop delete(int id) throws ShopNotFound {
		Shop deletedShop = shopRepository.findOne(id);
		
		if (deletedShop == null)
			throw new ShopNotFound();
		
		shopRepository.delete(deletedShop);
		return deletedShop;
	}

	@Override
	@Transactional
	public List<Shop> findAll() {
		return shopRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=ShopNotFound.class)
	public Shop update(Shop shop) throws ShopNotFound {
		Shop updatedShop = shopRepository.findOne(shop.getId());
		
		if (updatedShop == null)
			throw new ShopNotFound();
		
		updatedShop.setName(shop.getName());
        updatedShop.getEmployee().setId(shop.getEmployee().getId());
        updatedShop.getEmployee().setName(shop.getEmployee().getName());
        updatedShop.getEmployee().setLastName(shop.getEmployee().getLastName());
		return updatedShop;
	}


    @Transactional
    public List<Shop> findByName(String name) {
        List<Shop> listShop = shopRepository.findByName(name);

        return listShop;
    }

    @Override
    public List<Shop> searchByName(String name) {
        List<Shop> listShop = shopRepository.searchByName(name);

        return listShop;
    }

    @Override
    public List<Shop> findByNameAndEmplNumber(String name, Integer emplNumber) {
        List<Shop> listShop = shopRepository.findByNameAndEmployeeId(name, emplNumber);
        return listShop;
    }

}
