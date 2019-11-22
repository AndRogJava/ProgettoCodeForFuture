
package com.ats.dao;

import com.ats.exception.DaoException;

public interface IdGeneratorInterface {
	
	int getNextId() throws DaoException, ClassNotFoundException; 
}