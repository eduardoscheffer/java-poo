package interfaces.exercicioFixacao.model.services;

import interfaces.exercicioFixacao.model.entities.Contract;
import interfaces.exercicioFixacao.model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months) {
        for (int i = 1; i <= months ; i++) {

            double cotaBasica = contract.getTotalValue() / months; // prestação basica
            LocalDate dueDate = contract.getDate().plusMonths(i);
            Double juros = paymentService.interest(cotaBasica, i);
            double paymentFee = paymentService.paymentFee(juros + cotaBasica);

            contract.addInstallment(new Installment(dueDate, (cotaBasica + juros + paymentFee)));

        }
    }
}
