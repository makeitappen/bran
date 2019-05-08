//
//  ViewController.swift
//  bran
//
//  Created by Roland Michelberger on 08.05.19.
//  Copyright © 2019 makeitappen GmbH. All rights reserved.
//

import UIKit
import Shared

class ViewController: UIViewController {
    
    @IBOutlet private weak var label: UILabel!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        label.text = DeviceInfo().osVersion
    }

}

