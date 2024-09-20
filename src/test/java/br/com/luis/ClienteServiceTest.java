package br.com.luis;

import br.com.luis.dao.ClienteDaoMock;
import br.com.luis.dao.IClienteDAO;
import br.com.luis.domain.Cliente;
import br.com.luis.services.ClienteService;
import br.com.luis.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService iClienteService;
    private Cliente cliente;
    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        iClienteService = new ClienteService(dao);
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

        iClienteService.salvar(cliente);
    }


@Test
    public void procurarCliente() {
    Cliente clienteConsultado = iClienteService.buscarPorCPF(cliente.getCpf());

    Assert.assertNotNull(clienteConsultado);
}
    @Test
    public void salvarCliente() {
        Boolean retorno = iClienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        iClienteService.excluir(cliente.getCpf());
    }

}
