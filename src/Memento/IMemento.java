package Memento;

import java.time.LocalDateTime;

public interface IMemento {
    LocalDateTime getTimestamp();
    String getTimestampFormatted();
}
