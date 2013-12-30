package org.instorm.service;

import java.util.List;

import org.instorm.model.Couple;
import org.instorm.model.LoveHistory;
import org.instorm.model.Pet;
import org.instorm.model.User;

public interface CoupleService {
	/**
	 * create a new couple
	 * @param user1
	 * @param user2
	 * @param name
	 * @return
	 */
	public Couple newCouple(User user1, User user2, String name);
	/**
	 * get Couple by couple id
	 * @param id couple id
	 * @return
	 */
	public Couple getCouple(Integer id);
	/**
	 * get couples whoes's loveindex rank < rank
	 * @param rank
	 * @return
	 */
	public List getRankCouples(int rank);
	/**
	 * find couple by user
	 * @param user
	 * @return null if the user is single
	 */
	public Couple getUserCouple(User user);
	/**
	 * 
	 * @param couple
	 * @return
	 */
	public List getCoupleLoveHistories(Couple couple);
	/**
	 * add love history
	 * @param loveHistory
	 */
	public void addLoveHistory(LoveHistory loveHistory);
	/**
	 * get all lovehistories
	 * @return
	 */
	public List getAllLoveHistories();
	/**
	 * 
	 * @param coupleId
	 * @return
	 */
	public Pet getPet(Integer coupleId);
	/**
	 * 
	 * @param index
	 */
	public void addPetHeartIndex(Pet pet, int index);
	/**
	 * 
	 * @param pet
	 */
	public void addPet(Pet pet);
}
