import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AppProvider from "./context/AppProvider";
import Home from "./pages/Home/Home";
import Login from "./pages/Login/Login";
import NotFound from "./pages/NotFound/NotFound";
import Profile from "./pages/Profile/Profile";
import Register from "./pages/Register/Register";

const App = () => {
  return (
    <AppProvider>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </Router>
    </AppProvider>
  );
};

export default App;
