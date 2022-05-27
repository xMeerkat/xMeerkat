package v;

import org.jetbrains.annotations.NotNull;
import java.net.URI;

public record Video (@NotNull String name, @NotNull String author, @NotNull URI url, @NotNull String description, @NotNull String date, @NotNull String ID, @NotNull String category) {


    public Video {
    }
}
