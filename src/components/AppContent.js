import React, {Component} from 'react';
import PropTypes from 'prop-types';
import WelcomeContent from "./WelcomeContent";
import {AuthContent} from "./AuthContent";

class AppContent extends Component {
    render() {
        return (
            <div>
                <WelcomeContent/>
                <AuthContent></AuthContent>

                
            </div>
        );
    }
}

AppContent.propTypes = {};

export default AppContent;
