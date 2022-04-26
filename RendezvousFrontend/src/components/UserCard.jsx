import { React, useContext, useEffect, useState } from "react";
import AppContext from "../context/app-context";
import RendezvousService from "../repository/RendezvousRepository";
import "./UserCard.css";

const UserCard = () => {
  const appContext = useContext(AppContext);

  const [matchPercent, setMatchPercent] = useState(0);

  const fetchMatchPercent = (userId, shownUserId) => {
    RendezvousService.getMatchPercentForUsers(userId, shownUserId)
      .then((response) => {
        return response.data;
      })
      .then((data) => {
        console.log(data);
        setMatchPercent(data.toFixed(0));
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    fetchMatchPercent(appContext.activeUser.id, appContext.users[0].id);
  }, [appContext]);

  return (
    <div className="user-card">
      <div className="user-image"></div>
      <section className="user-info">
        <h4 className="name">
          {`${appContext.users[0].name} ${appContext.users[0].surname}`}
        </h4>
        <p className="desc">
          According to common interests, this user is a{" "}
          <span className="percent">{matchPercent}% </span>match.
        </p>
      </section>
    </div>
  );
};

export default UserCard;
