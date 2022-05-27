package xms.v;

import org.jetbrains.annotations.NotNull;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public final class Video {

    /** Name of the video */
    public final @NotNull String title;

    /** Creator of the video */
    public final @NotNull String author;

    /** URI to the video binary */
    public final @NotNull URI url;

    /** Video description */
    public final @NotNull String description;

    /** Upload Date */
    public final @NotNull Date date;

    /** Video ID */
    public final @NotNull UUID ID;



    public Video (@NotNull String title, @NotNull String author, @NotNull String url, @NotNull String description, @NotNull String date, @NotNull String ID, @NotNull List<String> tags) {

        // Title Length must not be more than 100 characters
        if (title.length() > 100) {
            this.title = title.substring(0, 100);
        } else {
            this.title = title;
        }

        // Author Length must not be more than 30 characters
        if (author.length() > 30) {
            this.author = author.substring(0, 30);
        } else {
            this.author = author;
        }


        // Move String URL to a URI
        this.url = URI.create(url);

        // Description Length must not be more than 1000 characters
        if (description.length() > 1000) {
            this.description = description.substring(0, 1000);
        } else {
            this.description = description;
        }


        // Move String Date to a Date
        this.date = new Date(Date.parse(date));


        // Video ID must be a UUID
        this.ID = UUID.fromString(ID);


    }
}
