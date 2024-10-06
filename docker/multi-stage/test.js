// test.js
import { check, sleep } from 'k6';
import http from 'k6/http';

export const options = {
    discardResponseBodies: true,
    scenarios: {
        contacts: {
            executor: 'constant-arrival-rate',

            // How long the test lasts
            duration: '2m',

            // How many iterations per timeUnit
            rate: 100,

            // Start `rate` iterations per second
            timeUnit: '1s',

            // Pre-allocate 2 VUs before starting the test
            preAllocatedVUs: 10,

            // Spin up a maximum of 50 VUs to sustain the defined
            // constant arrival rate.
            maxVUs: 20,
        },
    },
};

export default function() {
    var url = "http://localhost:7777/health";
    let res = http.get(url);
    check(res, {
        "is status 200": (r) => r.status === 200
    },);
    sleep(0.2);
}

//k6 run -u 200 -d 2m --summary-export=export.json --out json=my_test_result.json test.js