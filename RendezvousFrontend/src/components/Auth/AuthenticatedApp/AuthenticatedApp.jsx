import React, { useContext, useEffect } from "react";
import AppContext from "../../../context/app-context";
import RendezvousService from "../../../repository/RendezvousRepository";
import "./AuthenticatedApp.css";

const AuthenticatedApp = () => {
  const appContext = useContext(AppContext);

  const loadUsers = () => {
    RendezvousService.fetchUsers().then((response) => {
      appContext.dispatch({
        type: "LOAD_USERS",
        users: response.data,
      });
    });
  };

  const logOutHandler = () => {
    appContext.dispatch({
      type: "LOGOFF",
    });
  };

  useEffect(() => {
    loadUsers();
  }, [appContext.users, loadUsers]);

  return (
    <div className="auth app">
      <h1>This is the authenticated app.</h1>
      <button onClick={() => logOutHandler()}>LOGOFF</button>
      <ul>
        {appContext.users.length > 0
          ? appContext.users.map((user) => (
              <li key={user.id}>{user.name + " " + user.surname}</li>
            ))
          : "No Users are present."}
      </ul>
    </div>
  );
};

export default AuthenticatedApp;
