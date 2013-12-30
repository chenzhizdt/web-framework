package org.instorm.service.impl;

import java.util.Date;
import java.util.List;

import org.instorm.dao.BasicDAO;
import org.instorm.model.Couple;
import org.instorm.model.LoveHistory;
import org.instorm.model.Pet;
import org.instorm.model.User;
import org.instorm.service.CoupleService;

public class CoupleServiceImpl implements CoupleService{
	
	private BasicDAO basicDAO;
	
	public BasicDAO getBasicDAO() {
		return basicDAO;
	}

	public void setBasicDAO(BasicDAO basicDAO) {
		this.basicDAO = basicDAO;
	}

	@Override
	public Couple newCouple(User user1, User user2, String name) {
		Couple couple = new Couple();
		couple.setUserId1(user1.getId());
		couple.setUserId2(user2.getId());
		couple.setName(name);
		couple.setCreateTime(new Date());
		couple.setUpdateTime(new Date());
		basicDAO.save(couple);
		user1.setCoupleId(couple.getId());
		user1.setUpdateTime(new Date());
		user2.setCoupleId(couple.getId());
		user2.setUpdateTime(new Date());
		return couple;
	}

	@Override
	public Couple getCouple(Integer id) {
		String hql = "from Couple where id = ?";
		List list = basicDAO.find(hql, id);
		if(list.iterator().hasNext()){
			return (Couple) list.iterator().next();
		}
		return null;
	}

	@Override
	public List getRankCouples(int rank) {
		String hql = "from Couple order by loveIndex desc limit ?";
		return basicDAO.find(hql, rank);
	}

	@Override
	public Couple getUserCouple(User user) {
		String hql = "from Couple where id = ?";
		return getCouple(user.getCoupleId());
	}

	@Override
	public List getCoupleLoveHistories(Couple couple) {
		String hql = "from LoveHistory where coupleId = ? order by createTime asc";
		return basicDAO.find(hql, couple.getId());
	}

	@Override
	public void addLoveHistory(LoveHistory loveHistory) {
		basicDAO.save(loveHistory);
	}

	@Override
	public List getAllLoveHistories() {
		String hql = "from LoveHistory order by createTime asc";
		return basicDAO.find(hql);
	}

	@Override
	public Pet getPet(Integer coupleId) {
		String hql = "from Pet where coupleId = ?";
		List list = basicDAO.find(hql, coupleId);
		if(list.iterator().hasNext()){
			return (Pet) list.iterator().next();
		}
		return null;
	}

	@Override
	public void addPetHeartIndex(Pet pet, int index) {
		pet.setHeartIndex(pet.getHeartIndex() + index);
		basicDAO.saveOrUpdate(pet);
	}

	@Override
	public void addPet(Pet pet) {
		basicDAO.save(pet);
	}
	
}
