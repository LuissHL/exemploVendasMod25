package br.com.luis;

import br.com.luis.dao.ClienteDaoMock;
import br.com.luis.dao.IClienteDAO;
import br.com.luis.domain.Cliente;
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
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(123232323L);
        cliente.setNome("luis");
        cliente.setCidade("São paulo");
        cliente.setEstado("SP");
        cliente.setTel(33234233L);
        cliente.setEnd("end");
        cliente.setNumero(12);

        clienteDao.salvar(cliente);
    }

    @Test
    public void procurarCliente() {
        Cliente clienteConsultado = clienteDao.buscarPorCPF(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() {
       Boolean retorno = clienteDao.salvar(cliente);
       Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }
}
