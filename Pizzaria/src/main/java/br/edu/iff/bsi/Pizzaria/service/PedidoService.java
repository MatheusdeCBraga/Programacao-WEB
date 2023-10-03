package br.edu.iff.bsi.Pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.bsi.Pizzaria.entities.Cliente;
import br.edu.iff.bsi.Pizzaria.entities.Funcionario;
import br.edu.iff.bsi.Pizzaria.entities.Pedido;
import br.edu.iff.bsi.Pizzaria.repository.PedidoRepository;
import br.edu.iff.bsi.Pizzaria.entities.Pizza;
import br.edu.iff.bsi.Pizzaria.repository.PizzaRepository;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FuncionarioService funcionarioService;

    public List<Pizza> listarPizzasComIngredientes() {
        return pizzaService.listarPizzasComIngredientes();
    }

    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }

    public void salvarPedido(Pedido pedido, List<Long> selectedPizzasIds, Long selectedClienteId, Long selectedFuncionarioId) throws NotFoundException {
        List<Pizza> selectedPizzas = pizzaService.buscarPizzaPorIds(selectedPizzasIds);
        pedido.setPizza(selectedPizzas);

        Cliente selectedCliente = clienteService.getClienteById(selectedClienteId);
        pedido.setCliente(selectedCliente);

        Funcionario selectedFuncionario = funcionarioService.getFuncionarioById(selectedFuncionarioId);
        pedido.setFuncionario(selectedFuncionario);

        pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public void atualizarPedido(Pedido pedido) {
        if (pedido.getId() != null) {
            pedidoRepository.save(pedido);
        }
    }

    public void removerPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}




