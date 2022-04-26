import { React, useContext, useEffect, useState } from "react";
import Button from "../../components/Helper/Button";
import Card from "../../components/Helper/Card";
import Hobbies from "../../components/Lists/Hobbies";
import MusicGenres from "../../components/Lists/Music Genres";
import Locations from "../../components/Lists/Locations";
import Sports from "../../components/Lists/Sports";
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
  });

  useEffect(() => {
    setUser({
      username: appContext.activeUser.username,
      name: appContext.activeUser.name,
      surname: appContext.activeUser.surname,
      email: appContext.activeUser.email,
      city: appContext.activeUser.city,
    });
  }, [appContext]);

  return (
    <div className="profile page">
      <div className="profile-pic"></div>

      <section className="personal">
        <h2 className="name">
          {user.name} {user.surname}
        </h2>

        <span className="username">( {user.username} )</span>

        <Card>
          <div className="personal-row">
            <p className="email-label">Email:</p>
            <span className="email">{user.email}</span>
          </div>

          <div className="personal-row">
            <p className="city-label">Lives in:</p>
            <span className="city">{user.city}</span>
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
    </div>
  );
};

export default Profile;
