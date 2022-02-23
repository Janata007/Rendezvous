import React, { useEffect, useState } from "react";
import RendezvousService from "./repository/RendezvousRepository";
import "./styles/App.css";

const App = () => {
  const [users, setUsers] = useState([]);

  const loadUsers = () => {
    RendezvousService.fetchUsers()
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    loadUsers();
  }, []);

  return (
    <div className="app">
      <h1>This is our app for now.</h1>
      <br />
      <ul>
        {users.map((user) => (
          <li key={user.name}>
            {user.name} {user.surname}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default App;
