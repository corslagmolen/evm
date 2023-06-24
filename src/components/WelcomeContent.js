import React, {Component} from 'react';
import PropTypes from 'prop-types';

class WelcomeContent extends Component {
    render() {
        return (
            <div className="row justify-content-md-center">
                <div className="jumbotron jumbotron-fluid">
                    <div className="container">
                        <h1 className="display-4">Welcome</h1>
                        <p className="lead">Login to see protected content</p>
                    </div>

                </div>

                
            </div>
        );
    }
}

WelcomeContent.propTypes = {};

export default WelcomeContent;
