import { React, useContext, useEffect } from "react";
import Card from "../../components/Helper/Card";
import AppContext from "../../context/app-context";
import Header from "../../components/Layout/Header";
import Footer from "../../components/Layout/Footer";
import "./Matches.css";

const Matches = () => {
  const appContext = useContext(AppContext);

  useEffect(() => {}, [appContext]);

  return (
    <div className="match page">
      <Header />
      <div className="container">
        <Card>
          <h1 className="match-title">Your Matches</h1>
        </Card>

        <div className="matches-container">
          {appContext.matchedUsers.length > 0 ? (
            appContext.matchedUsers.map((user) => {
              return (
                <div className="match-box">
                  <div className="matched-user">
                    <div className="matched-image"></div>
                    <div className="matched-info">
                      {`${user.name} ${user.surname}`}
                    </div>
                  </div>
                  <button className="button nav-button match-button">
                    Chat With User
                  </button>
                </div>
              );
            })
          ) : (
            <p>You currently have no matches... yet :D</p>
          )}
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default Matches;
