
package acme.features.administrator.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.accounts.Administrator;
import acme.client.data.models.Dataset;
import acme.client.services.AbstractService;
import acme.entities.banners.Banner;

@Service
public class AdministratorBannerDeleteService extends AbstractService<Administrator, Banner> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorBannerRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		final int id = super.getRequest().getData("id", int.class);
		final Banner object = this.repository.findBannerById(id);
		super.getBuffer().addData(object);
	}

	@Override
	public void bind(final Banner object) {
		assert object != null;
		super.bind(object, "instantiationMoment", "startDate", "endDate", "picture", "slogan", "link");
	}

	@Override
	public void validate(final Banner object) {
		assert object != null;
	}

	@Override
	public void perform(final Banner object) {
		assert object != null;
		this.repository.delete(object);
	}

	@Override
	public void unbind(final Banner object) {
		assert object != null;
		Dataset dataset;

		dataset = super.unbind(object, "instantiationMoment", "startDate", "endDate", "picture", "slogan", "link");
		super.getResponse().addData(dataset);
	}
}
