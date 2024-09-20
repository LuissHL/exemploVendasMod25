package br.com.luis;

import br.com.luis.dao.ClienteDaoMock;
import br.com.luis.dao.IClienteDAO;
import br.com.luis.domain.Cliente;
import br.com.luis.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDaoTest {

    private IClienteDAO clienteDao;
    private Cliente cliente;

    public ClienteDaoTest() {

        this.clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(123232323L);
        cliente.setNome("luis");
        cliente.setCidade("São paulo");
        cliente.setEstado("SP");
        cliente.setTel(33234233L);
        cliente.setEnd("end");
        cliente.setNumero(12);

        clienteDao.cadastrar(cliente);
    }

    @Test
    public void procurarCliente() {
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException{
       Boolean retorno = clienteDao.cadastrar(cliente);
       Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException{
        cliente.setNome("Luis henrique");
        clienteDao.alterar(cliente);

        Assert.assertEquals("Luis henrique",cliente.getNome());
    }
}
