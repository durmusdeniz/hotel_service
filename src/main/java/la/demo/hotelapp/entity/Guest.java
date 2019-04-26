package la.demo.hotelapp.entity;

import java.util.Objects;

public class Guest {


    private String fullname;

    private String email;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Guest(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return email.equals(guest.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return  "{\"fullname\":\""+fullname+"\", \"email\":\""+email+"\"}";
    }
}
