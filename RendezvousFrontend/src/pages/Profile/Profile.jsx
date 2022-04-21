import { React, useContext, useEffect, useState } from "react";
import Button from "../../components/Helper/Button/Button";
import Card from "../../components/Helper/Card/Card";
import AppContext from "../../context/app-context";
import RendezvousService from "../../repository/RendezvousRepository";
import "./Profile.css";
const Profile = () => {
  const appContext = useContext(AppContext);

  const [user, setUser] = useState({
    name: "",
    surname: "",
    username: "",
    email: "",
    city: "",
  });

  useEffect(() => {
    RendezvousService.fetchUserByUsername("Marko")
      .then((response) => {
        return response;
      })
      .then((data) => {
        return data.data;
      })
      .then((userInfo) => {
        setUser({
          name: userInfo.name,
          surname: userInfo.surname,
          username: userInfo.username,
          email: userInfo.email,
          city: userInfo.city,
        });
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

      <Button text="Back to Homepage" navigateTo="" />
    </div>
  );
};

export default Profile;
