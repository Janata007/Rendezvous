import { React, useContext, useEffect, useState } from "react";
import { FcLike, FcDislike } from "react-icons/fc";
import { TiArrowRightThick } from "react-icons/ti";
import AppContext from "../context/app-context";
import RendezvousService from "../repository/RendezvousRepository";
import Card from "./Helper/Card";
import "./UserCard.css";

const UserCard = () => {
  const appContext = useContext(AppContext);

  const [matchPercent, setMatchPercent] = useState(0);

  const likeHandler = () => {
    RendezvousService.likeUser(appContext.activeUser.id, appContext.users[0].id)
      .then((response) => {
        let likedUser = appContext.users[0];

        appContext.dispatch({
          type: "LIKED_USER",
          likedUser: appContext.users[0],
        });

        return likedUser;
      })
      .then((user) => {
        RendezvousService.areUsersMatched(appContext.activeUser.id, user.id)
          .then((response) => {
            console.log(response.data);
            if (response.data) {
              appContext.dispatch({ type: "MATCHED_USER", matchedUser: user });
            }
          })
          .catch((error) => console.log(error));
      })
      .catch((error) => console.log(error));
  };

  const dislikeHandler = () => {
    RendezvousService.dislikeUser(
      appContext.activeUser.id,
      appContext.users[0].id
    )
      .then((response) => {
        appContext.dispatch({
          type: "DISLIKED_USER",
          dislikedUser: appContext.users[0],
        });
      })
      .catch((error) => console.log(error));
  };

  const skipHandler = () => {
    let userToBeSkipped = appContext.users[0];

    appContext.dispatch({ type: "SKIPPED_USER", user: userToBeSkipped });
  };

  useEffect(() => {
    const fetchMatchPercent = () => {
      RendezvousService.getMatchPercentForUsers(
        appContext.activeUser.id,
        appContext.users[0].id
      )
        .then((response) => {
          return response.data;
        })
        .then((data) => {
          setMatchPercent(data.toFixed(0));
        })
        .catch((error) => {
          console.log(error);
        });
    };

    if (appContext.users.length > 0) fetchMatchPercent();
  }, [appContext]);

  return (
    <>
      {appContext.users.length > 0 ? (
        <>
          <div className="user-card">
            <div className="user-image"></div>
            <section className="user-info">
              <h4 className="name">{`${appContext.users[0].name} ${appContext.users[0].surname}`}</h4>
              <p className="desc">
                According to common interests, this user is a{" "}
                <span className="percent">{matchPercent}% </span>match.
              </p>
            </section>
          </div>
          <div className="user-actions">
            <div className="action-button" onClick={() => dislikeHandler()}>
              <FcDislike />
            </div>
            <div className="action-button" onClick={() => likeHandler()}>
              <FcLike />
            </div>
            <div className="action-button" onClick={() => skipHandler()}>
              <TiArrowRightThick />
            </div>
          </div>
        </>
      ) : (
        <Card>
          <h1 className="empty-title">
            There seems to be no one around currently, check back later :)
          </h1>
        </Card>
      )}
    </>
  );
};

export default UserCard;
