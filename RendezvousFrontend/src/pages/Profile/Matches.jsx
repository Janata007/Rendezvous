import { React, useContext, useEffect } from "react";
import Card from "../../components/helper/Card";
import AppContext from "../../context/app-context";
import Header from "../../components/layout/Header";
import Footer from "../../components/layout/Footer";
import "./Matches.css";

const Matches = () => {
  const appContext = useContext(AppContext);

  const chatHandler = () => {
    window.location = "http://localhost:9000/adminPage/chat";
  };

  useEffect(() => {}, [appContext]);

  return (
    <div className="match page">
      <Header />
      <div className="container">
        <Card>
          <h1 className="match-title">
            {appContext.matchedUsers.length > 0
              ? "Your Matches"
              : "You currently have no matches."}
          </h1>
        </Card>

        <div className="matches-container">
          {appContext.matchedUsers.length > 0 &&
            appContext.matchedUsers.map((user) => {
              return (
                <div key={user.id} className="match-box">
                  <div className="matched-user">
                    <div className="matched-image"></div>
                    <div className="matched-info">
                      {`${user.name} ${user.surname}`}
                    </div>
                  </div>
                  <button
                    className="button nav-button match-button"
                    onClick={() => chatHandler()}
                  >
                    Chat With User
                  </button>
                </div>
              );
            })}
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default Matches;
