package com.sda.carrental.service;


        import com.sda.carrental.dto.ReservationDto;
        import com.sda.carrental.repository.ReservationRepository;
        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationDto findReservationById(Long id) {
        return ReservationDto.from(reservationRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }


}