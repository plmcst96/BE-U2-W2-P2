package cristinapalmisani.BEU2W2P2.repositories;

import cristinapalmisani.BEU2W2P2.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceRepositoryDAO extends JpaRepository<Device, UUID> {
}
