import { React, useContext, useEffect, useState } from "react";
import Button from "../../components/helper/Button";
import Card from "../../components/helper/Card";
import Hobbies from "../../components/lists/Hobbies";
import MusicGenres from "../../components/lists/Music Genres";
import Locations from "../../components/lists/Locations";
import Sports from "../../components/lists/Sports";
import AppContext from "../../context/app-context";
import "./Profile.css";
const Profile = () => {
  const appContext = useContext(AppContext);

  const [user, setUser] = useState({
    username: "",
    name: "",
    surname: "",
    email: "",
    city: "",
    geoLocation: "",
    authority: "",
  });

  const checkGeoLocation = () => {
    return user.geoLocation.search("unsupported");
  };

  const adminRedirectHandler = () => {
    window.location = "http://localhost:9000/adminPage";
  };

  useEffect(() => {
    setUser({
      username: appContext.activeUser.username,
      name: appContext.activeUser.name,
      surname: appContext.activeUser.surname,
      email: appContext.activeUser.email,
      city: appContext.activeUser.city,
      geoLocation: appContext.activeUser.geoLocation,
      authority: appContext.activeUser.authority,
    });
  }, [appContext]);

  return (
    <div className="profile page">
      <div className="profile-pic"></div>

      <section className="personal">
        <h1 className="name-title">
          {user.name} {user.surname}
        </h1>

        <span className="username">( {user.username} )</span>

        <Card>
          <div className="personal-row">
            <p className="email-label">Email:</p>
            <span className="email">{user.email}</span>
          </div>

          <div className="personal-row">
            <p className="city-label">Lives in:</p>
            <p className={`city ${checkGeoLocation() ? "invalid" : ""}`}>
              {user.geoLocation}
            </p>
          </div>
        </Card>
      </section>

      <Card>
        <Hobbies />
      </Card>

      <Card>
        <Sports />
      </Card>

      <Card>
        <MusicGenres />
      </Card>

      <Card>
        <Locations />
      </Card>

      <Button text="Back to Homepage" navigateTo="" />
      {user.authority === "ADMIN" ? (
        <button
          className="button nav-button"
          onClick={() => adminRedirectHandler()}
        >
          Go To Admin Page
        </button>
      ) : null}
    </div>
  );
};

export default Profile;
