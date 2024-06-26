
package acme.features.any.project;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.client.controllers.AbstractController;
import acme.client.data.accounts.Any;
import acme.entities.project.Project;

@Controller
public class AnyProjectController extends AbstractController<Any, Project> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnyProjectShowService	showService;

	@Autowired
	private AnyProjectListService	listService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("list", this.listService);
	}

}
