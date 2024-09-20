package br.com.luis.services;

import br.com.luis.dao.ClienteDAO;
import br.com.luis.dao.IClienteDAO;
import br.com.luis.domain.Cliente;

public class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;
    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    @Override
    public Boolean salvar(Cliente cliente) {
       return clienteDAO.salvar(cliente);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return clienteDAO.buscarPorCPF(cpf);
    }

    @Override
    public void excluir(Long cpf) {
       // clienteDAO.excluir(cpf);
    }
}
