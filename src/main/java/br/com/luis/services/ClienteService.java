package br.com.luis.services;

import br.com.luis.dao.IClienteDAO;
import br.com.luis.dao.generics.IGenericDAO;
import br.com.luis.services.generics.GenericService;
import br.com.luis.domain.Cliente;
import br.com.luis.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {


    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        //this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
       return this.dao.consultar(cpf);
    }
}
