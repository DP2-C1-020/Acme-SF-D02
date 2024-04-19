
package acme.features.any.progressLogs;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.progress_logs.ProgressLog;

@Repository
public interface AnyProgressLogsRepository extends AbstractRepository {

	@Query("select pl from ProgressLog pl where pl.contract.id = :id and pl.draftMode = false")
	Collection<ProgressLog> findProgressLogsPublishedByContract(int id);

	@Query("select pl from ProgressLog pl where pl.id = :id")
	ProgressLog findProgressLogsById(int id);

}
