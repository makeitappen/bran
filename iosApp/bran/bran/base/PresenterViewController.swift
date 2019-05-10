//
//  PresenterViewController.swift
//  bran
//
//  Created by Roland Michelberger on 08.05.19.
//  Copyright © 2019 makeitappen GmbH. All rights reserved.
//

import UIKit
import Shared

protocol PresenterProtocol: ViewI {
    
    var _presenter: Presenter { get }
    
}

class PresenterViewController: UIViewController, PresenterProtocol {
    
    internal var _presenter: Presenter { return nil! }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        _presenter.attach(view: self)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        _presenter.attach(view: self)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        _presenter.detach()
    }
}

class PresenterTabBarViewController: UITabBarController, PresenterProtocol {
    
    internal var _presenter: Presenter { return nil! }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        _presenter.attach(view: self)
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        _presenter.attach(view: self)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        _presenter.detach()
    }
}

 class PresenterNavigationController: UINavigationController, PresenterProtocol {
 
    internal var _presenter: Presenter { return nil! }

    override func viewDidLoad() {
        super.viewDidLoad()
        _presenter.attach(view: self)
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        _presenter.attach(view: self)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        _presenter.detach()
    }
}
 
class PresenterTableViewController: UITableViewController, PresenterProtocol {
    
    internal var _presenter: Presenter { return nil! }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        _presenter.attach(view: self)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        _presenter.attach(view: self)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        _presenter.detach()
    }
}

