package com.util.LinkedStorage;

import java.util.List;

public abstract class AbstractCirDoubleList<T> implements ADTList<T> {

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int index, T e) {
		// TODO Auto-generated method stub
		
	}
	public abstract int insert(int index, T e);

	@Override
	public int insert(T e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int search(T key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertDifferent(T e) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addAll(List<T> list) {
		
	}

}
