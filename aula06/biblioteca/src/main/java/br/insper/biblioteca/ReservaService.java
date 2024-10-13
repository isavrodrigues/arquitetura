package br.insper.biblioteca;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReservaService {

    private ArrayList<Reserva> reservas = new ArrayList<>();

    public void cadastrarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public ArrayList<Reserva> listarReservas() {
        return reservas;
    }

    public void removerReserva(String codigo) {
        reservas.removeIf(reserva -> reserva.getCodigo().equals(codigo));
    }
}