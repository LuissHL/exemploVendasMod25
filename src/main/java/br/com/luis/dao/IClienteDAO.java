package br.com.luis.dao;

import br.com.luis.domain.Cliente;

public interface IClienteDAO {
    Boolean salvar(Cliente cliente);

    Cliente buscarPorCPF(Long cpf);

    void excluir(Long cpf);
}
