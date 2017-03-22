package fr.esilv.s8.tdfinal.models;

import java.util.Date;


/**
 * Created by Pierre-Marie on 20/03/2017.
 */

public class Video {

    private String id;
        private String title;
        private String description;
        private String author;
        private String thumbnail;
        private Date publication_date;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Date getPublication_date() {
            return publication_date;
        }

        public void setPublication_date(Date publication_date) {
            this.publication_date = publication_date;
        }




}
