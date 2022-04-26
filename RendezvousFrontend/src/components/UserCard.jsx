import { React, useContext, useEffect, useState } from "react";
import { FcLike, FcDislike } from "react-icons/fc";
import { TiArrowRightThick } from "react-icons/ti";
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

  const likeHandler = () => {
    console.log("liked");
  };

  const dislikeHandler = () => {
    console.log("disliked");
  };

  const skipHandler = () => {
    console.log("skipped");
  };

  useEffect(() => {
    fetchMatchPercent(appContext.activeUser.id, appContext.users[0].id);
  }, [appContext]);

  return (
    <>
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
      <div className="user-actions">
        <div className="action-button" onClick={() => likeHandler()}>
          <FcLike />
        </div>
        <div className="action-button" onClick={() => dislikeHandler()}>
          <FcDislike />
        </div>
        <div className="action-button" onClick={() => skipHandler()}>
          <TiArrowRightThick />
        </div>
      </div>
    </>
  );
};

export default UserCard;
