import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AppProvider from "./context/AppProvider";
import Home from "./pages/Home/Home";
import Login from "./pages/Auth/Login";
import NotFound from "./pages/NotFound/NotFound";
import EditHobbies from "./pages/Profile/EditHobbies";
import EditLocations from "./pages/Profile/EditLocations";
import EditMusicGenres from "./pages/Profile/EditMusicGenres";
import EditSports from "./pages/Profile/EditSports";
import Profile from "./pages/Profile/Profile";
import Register from "./pages/Auth/Register";

const App = () => {
  return (
    <AppProvider>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/profile/editHobbies" element={<EditHobbies />} />
          <Route path="/profile/editSports" element={<EditSports />} />
          <Route
            path="/profile/editMusicGenres"
            element={<EditMusicGenres />}
          />
          <Route path="/profile/editLocations" element={<EditLocations />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </Router>
    </AppProvider>
  );
};

export default App;
