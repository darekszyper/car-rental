package com.sda.carrental.service;


        import com.sda.carrental.dto.CarDto;
        import com.sda.carrental.dto.ReservationDto;
        import com.sda.carrental.model.CarEntity;
        import com.sda.carrental.model.ReservationEntity;
        import com.sda.carrental.repository.ReservationRepository;
        import jakarta.validation.Valid;
        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationDto findReservationById(Long id) {
        return ReservationDto.from(reservationRepository.findById(id)
                .orElseThrow(RuntimeException::new));
    }

    public ReservationDto saveReservation(@Valid ReservationDto reservation) {
        return ReservationDto.from(ReservationRepository.save(ReservationEntity.toNewEntity(reservation)));
    }

    public void deleteReservationById(Long id) {
        ReservationEntity reservation = ReservationRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        ReservationRepository.delete(reservation);
    }

    public List<ReservationDto> findAllReservations() {
        return reservationRepository.findAll().stream().map(ReservationDto::from).collect(Collectors.toList());
    }

    public ReservationDto updateReservation(Long id, ReservationDto reservation) {
        ReservationEntity updateReservation = reservationRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        updateReservation.setReservationId(reservation.getReservationId());
        updateReservation.setStartDate(reservation.getStartDate());
        updateReservation.setEndDate(reservation.getStartDate());
        updateReservation.setReservationStatus(reservation.getReservationStatus());
        updateReservation.setCreditCardNumber(reservation.getCreditCardNumber());
        updateReservation.setReservationNumber(reservation.getReservationNumber());
        updateReservation.setPickUpLocation(reservation.getPickUpLocation());
        updateReservation.setReturnLocation(reservation.getReturnLocation());
        updateReservation.setCar(reservation.get);

        ReservationEntity savedReservation = ReservationRepository.save(updateReservation);

        return ReservationDto.from(savedRepository);
    }

}