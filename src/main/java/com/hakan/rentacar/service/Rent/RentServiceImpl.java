package com.hakan.rentacar.service.Rent;

import com.hakan.rentacar.repository.RentRepository;
import com.hakan.rentacar.entity.Rent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentServiceImpl implements RentService{

    private RentRepository rentRepository;

    public RentServiceImpl(RentRepository rentRepository){
        this.rentRepository = rentRepository;
    }

    @Override
    public List<Rent> findAllRents(){
        return rentRepository.findAll();
    }

    @Override
    public Optional<Rent> findRentById(Long id){
        return rentRepository.findById(id);
    }

    @Override
    public Rent saveRent(Rent rent){
        return rentRepository.save(rent);
    }

    @Override
    public void deleteRent(Long id){
        rentRepository.deleteById(id);
    }
}
