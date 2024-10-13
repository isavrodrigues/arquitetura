package br.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/reserva")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarReserva(@RequestBody Reserva reserva) {
        reservaService.cadastrarReserva(reserva);
        return "Reserva cadastrada com sucesso";
    }

    @GetMapping("/reserva")
    public ArrayList<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    @DeleteMapping("/reserva/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerReserva(@PathVariable String codigo) {
        reservaService.removerReserva(codigo);
    }
}
