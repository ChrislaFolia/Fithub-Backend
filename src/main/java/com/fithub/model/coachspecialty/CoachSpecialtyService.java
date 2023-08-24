package com.fithub.model.coachspecialty;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachSpecialtyService implements ICoachSpecialtyService{

	@Autowired
	private CoachSpecialtyDAO cDao;

	@Override
	public boolean insert(CoachSpecialty cBean) {
		CoachSpecialty result = cDao.findCoachSpecialtyByEmpidSpecId(cBean.getEmployeeid(), cBean.getSpecialtyid());
		System.out.println("result-------" + result);
		if(result == null) {
			CoachSpecialty resultBean = cDao.save(cBean);
			if (resultBean != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(CoachSpecialty cBean) {
		CoachSpecialty result = cDao.findCoachSpecialtyByEmpidSpecId(cBean.getEmployeeid(), cBean.getSpecialtyid());
		if(result == null) {
			CoachSpecialty resultBean = cDao.save(cBean);
			if (resultBean != null) {
				return true;
			}
		}
	
		return false;
	}

	@Override
	public void deleteById(Integer id) {
		cDao.deleteById(id);
	}

	@Override
	public CoachSpecialty findById(Integer id) {
		Optional<CoachSpecialty> optional = cDao.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	@Override
	public List<CoachSpecialty> findAll() {
		List<CoachSpecialty> list = cDao.findAll();
		return list;
	}
}