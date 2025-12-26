public interface DigitalKeyService {

    DigitalKey generateKey(Long bookingId);

    DigitalKey getActiveKeyForBooking(Long bookingId);

    List<DigitalKey> getKeysForGuest(Long guestId);

    DigitalKey getKeyById(Long id);
}
