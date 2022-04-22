import { React, useContext, useEffect, useState } from "react";
import Button from "../../components/Helper/Buttons/Button";
import Card from "../../components/Helper/Card/Card";
import AppContext from "../../context/app-context";
import "./Profile.css";
const Profile = () => {
  const appContext = useContext(AppContext);

  const [user, setUser] = useState({
    username: appContext.activeUser.username,
    name: appContext.activeUser.name,
    surname: appContext.activeUser.surname,
  });

  useEffect(() => {
    setUser({
      ...appContext.activeUser,
    });
  }, [appContext]);

  return (
    <div className="profile page">
      <div className="profile-pic"></div>

      <section className="personal">
        <h2 className="name">
          {appContext.activeUser.name} {appContext.activeUser.surname}
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
