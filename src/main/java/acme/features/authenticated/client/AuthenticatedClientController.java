
package acme.features.authenticated.client;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.client.controllers.AbstractController;
import acme.client.data.accounts.Authenticated;
import acme.roles.Client;

@Controller
public class AuthenticatedClientController extends AbstractController<Authenticated, Client> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedClientCreateService	createService;

	@Autowired
	protected AuthenticatedClientUpdateService	updateService;

	// Contructors ------------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("create", this.createService);
		super.addBasicCommand("update", this.updateService);
	}

}
